package model.dao;

import model.dao.impl.ExemplarDaoFiles;
import model.dao.impl.ExemplarDaoJson;

public class DaoFactory {
    public static ExemplarDao createExemplarDao() {
        return new ExemplarDaoJson();
    }
}
