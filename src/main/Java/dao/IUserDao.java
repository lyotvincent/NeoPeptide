package dao;
import model.User;
import org.springframework.stereotype.Service;

@Service("IUserDao")
public interface IUserDao {
    User selectUser(long id);
}
