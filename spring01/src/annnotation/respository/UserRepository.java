package annnotation.respository;

import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository {
  void save();
}
