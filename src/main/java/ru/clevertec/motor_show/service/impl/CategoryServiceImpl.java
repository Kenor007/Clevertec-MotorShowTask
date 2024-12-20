package ru.clevertec.motor_show.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.clevertec.motor_show.factory.CategoryFactory;
import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.Category;
import ru.clevertec.motor_show.service.CategoryService;
import ru.clevertec.motor_show.util.HibernateUtil;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public void addCategory() {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Category category = CategoryFactory.getCategory();
            session.save(category);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(session.get(Category.class, id));
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategory(Category categoryUpdate, Long id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Category category = session.get(Category.class, id);
            category.setCarCategory(categoryUpdate.getCarCategory());
            session.update(category);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void linkCategoryWithCars(Long categoryId, List<Long> carIds) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();

            Category category = session.get(Category.class, categoryId);
            if (category == null) {
                throw new IllegalArgumentException("Category with ID " + categoryId + " not found.");
            }

            for (Long carId : carIds) {
                Car car = session.get(Car.class, carId);
                if (car == null) {
                    throw new IllegalArgumentException("Car with ID " + carId + " not found.");
                }

                car.setCategories(category);
                category.getCars().add(car);

                session.update(car);
            }

            session.update(category);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}