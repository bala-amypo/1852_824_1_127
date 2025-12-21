public class UserServiceimpl implements UserService{
        
    public interface UserService(){
        @Autowired
        UserRepository obj;
       public User saveUser(User user){
         return obj.save(user);
       }
       public User findByEmail(String email){
        return obj.findByEmail(email);
       }
    }
}
