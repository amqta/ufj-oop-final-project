package model.dao;

import model.dao.impl.ExemplarDaoFiles;

public class DaoFactory {
    public static ExemplarDao createExemplarDao() {
        return new ExemplarDaoFiles();
    }
}
