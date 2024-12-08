package ru.clevertec.motor_show.service.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.clevertec.motor_show.factory.ClientFactory;
import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.Client;
import ru.clevertec.motor_show.service.ClientService;
import ru.clevertec.motor_show.util.HibernateUtil;

import java.util.List;

@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    @Override
    public void createClient() {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Client client = ClientFactory.createClient();
            session.save(client);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateClient(Client clientUpdate, Long id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Client client = session.get(Client.class, id);
            client.setName(clientUpdate.getName());
            client.setContacts(clientUpdate.getContacts());
            session.update(client);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteClient(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.delete(client);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buyCar(Long clientId, Long carId) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Client client = session.get(Client.class, clientId);
            Car car = session.get(Car.class, carId);
            car.setShowroom(null);
            List<Car> cars = List.of(car);
            List<Client> clients = List.of(client);
            client.setCars(cars);
            car.setClients(clients);
            session.update(client);
            session.update(car);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}