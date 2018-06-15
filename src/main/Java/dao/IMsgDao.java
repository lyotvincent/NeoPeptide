package dao;

import model.Msg;
import org.springframework.stereotype.Service;

@Service("IMsgDao")
public interface IMsgDao {
    int deleteByPrimaryKey(Long id);

    int insert(Msg record);

    int insertSelective(Msg record);

    Msg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKey(Msg record);
}