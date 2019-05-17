package model.dao.mapper;

import java.sql.ResultSet;

public interface Mapper<E> {

    E getEntityFromResSet(ResultSet resultSet, int... index);

}
