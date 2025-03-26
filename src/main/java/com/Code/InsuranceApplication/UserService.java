import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() {
        // Sample users
        users.add(new User(1L, "John Doe", 30, "MALE", 50000));
        users.add(new User(2L, "Jane Smith", 25, "FEMALE", 60000));
    }

    public User getUserById(Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}