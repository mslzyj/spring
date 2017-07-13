package annnotation.respository;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public void save() {
     System.out.println("UserRepository save");
	}

}
