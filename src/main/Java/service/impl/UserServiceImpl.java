package service.impl;
import dao.IUserDao;
import model.User;
import org.springframework.stereotype.Service;
import service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {


    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}