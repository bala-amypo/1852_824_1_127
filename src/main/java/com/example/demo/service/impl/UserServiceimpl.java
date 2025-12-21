public class UserServiceimpl implements UserService{

    public interface UserService(){
       publiv User saveUser(User user);
        User findByEmail(String email);
    }
}
