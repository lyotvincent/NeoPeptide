package service.impl;

import dao.IMsgDao;
import model.Msg;
import org.springframework.stereotype.Service;
import service.IMsgService;

import javax.annotation.Resource;

@Service("MsgService")
public class MsgServiceImpl implements IMsgService {
    @Resource
    private IMsgDao MsgDao;
    public void insert(Msg record){
        MsgDao.insert(record);
    }
}
