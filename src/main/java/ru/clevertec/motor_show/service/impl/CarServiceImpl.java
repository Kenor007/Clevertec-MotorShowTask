package ru.clevertec.motor_show.service.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import ru.clevertec.motor_show.enums.car.CarBrand;
import ru.clevertec.motor_show.enums.category.CarCategory;
import ru.clevertec.motor_show.factory.CarFactory;
import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.CarShowroom;
import ru.clevertec.motor_show.service.CarService;
import ru.clevertec.motor_show.util.HibernateUtil;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    @Override
    public void findCarById(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            Car car = session.get(Car.class, id);
            System.out.println(car);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findCarByParams(CarBrand brandCar, LocalDate yearOfProduction, CarCategory category, String price) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            String[] priceBounds = (Objects.nonNull(price) && price.contains("-")) ? price.split("-") : null;
            String minPrice = (Objects.nonNull(priceBounds) && priceBounds.length > 0) ? priceBounds[0] : null;
            String maxPrice = (Objects.nonNull(priceBounds) && priceBounds.length > 1) ? priceBounds[1] : null;

            String hql = "FROM Car c WHERE c.brandCar = :brandCar " +
                    "AND c.yearOfProduction = :yearOfProduction " +
                    "AND c.categories.carCategory = :category " +
                    "AND CAST(c.price AS DOUBLE) BETWEEN :minPrice AND :maxPrice";

            Query<Car> carQuery = session.createQuery(hql, Car.class);
            carQuery.setParameter("brandCar", brandCar);
            carQuery.setParameter("yearOfProduction", yearOfProduction);
            carQuery.setParameter("category", category);
            carQuery.setParameter("minPrice", Double.parseDouble(minPrice));
            carQuery.setParameter("maxPrice", Double.parseDouble(maxPrice));

            List<Car> cars = carQuery.getResultList();

            cars.forEach(car -> System.out.println(car.getBrandCar() +
                    " " + car.getYearOfProduction() +
                    " " + car.getCategories().getCarCategory() +
                    " " + car.getPrice()));
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void findCarsSortedByPriceAsc() {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
            Root<Car> root = criteriaQuery.from(Car.class);

            List<Car> cars = session.createQuery(criteriaQuery).getResultList();

            List<Car> sortedCars = cars.stream()
                    .filter(car -> car.getPrice() != null && car.getPrice().matches("[0-9.]+"))
                    .sorted(Comparator.comparingDouble(car -> Double.parseDouble(car.getPrice())))
                    .toList();

            sortedCars.forEach(car -> System.out.println("Car: " + car.getBrandCar() + " " + car.getModel() + ", Price: " + car.getPrice()));
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void findCarsSortedByPriceDesc() {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
            Root<Car> root = criteriaQuery.from(Car.class);

            List<Car> cars = session.createQuery(criteriaQuery).getResultList();

            List<Car> sortedCars = cars.stream()
                    .filter(car -> car.getPrice() != null && car.getPrice().matches("[0-9.]+"))
                    .sorted((car1, car2) -> Double.compare(Double.parseDouble(car2.getPrice()), Double.parseDouble(car1.getPrice())))
                    .toList();

            sortedCars.forEach(car -> System.out.println("Car: " + car.getBrandCar() + " " + car.getModel() + ", Price: " + car.getPrice()));

            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findAllCars(int pageNumber, int pageSize) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            String hql = "SELECT DISTINCT c FROM Car c " +
                    "JOIN FETCH c.categories " +
                    "JOIN FETCH c.showroom";
            Query<Car> query = session.createQuery(hql, Car.class);
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);

            List<Car> cars = query.list();

            cars.forEach(car ->
                    System.out.println(car.getBrandCar() + " - " + car.getCategories().getCarCategory())
            );

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCar() {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Car car = CarFactory.getCar();
            session.save(car);
            tx.commit();
            System.out.println("Individual Client saved with ID: " + car.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCar(Car carUpdate, long id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();

            Car car = session.get(Car.class, id);

            car.setModel(carUpdate.getModel());
            car.setBrandCar(carUpdate.getBrandCar());
            car.setYearOfProduction(carUpdate.getYearOfProduction());
            car.setPrice(carUpdate.getPrice());

            session.update(car);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCarById(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Car car = session.find(Car.class, id);
            session.delete(car);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCarToShowroom(Car car, CarShowroom showroom) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Car carAssign = session.get(Car.class, car.getId());
            carAssign.setShowroom(showroom);
            session.update(carAssign);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}