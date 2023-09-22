package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectDB {
    private static ConnectDB instance;
    private EntityManagerFactory entityManagerFactory;
    private ConnectDB(){
        entityManagerFactory = Persistence.createEntityManagerFactory("www_lab02");

    }
    public static ConnectDB getInstance() {
        if (instance == null){
            instance = new ConnectDB();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
