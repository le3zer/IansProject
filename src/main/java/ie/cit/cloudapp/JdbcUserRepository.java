package ie.cit.cloudapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcUserRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcUserRepository(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	JdbcUserRepository() {
		
	}
	
	public void save(User user){
		jdbcTemplate.update("insert into members(firstName, surname, email, done) values(?,?,?,?)",
					user.getFirstName(), user.getSurname(), user.getEmail(), user.isDone());
	}
	
	public User get(int id){
		return jdbcTemplate.queryForObject(
				"select id, firstName, surname, email from members where id=?", new UserMapper(),
				id);
	}
	
	public List<User> getAll() {
		return jdbcTemplate.query(
				"select id, firstName, surname, email, done from members", 
				new UserMapper());
	}

}

class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	User user = new User();
	user.setFirstName(rs.getString("firstName"));
	user.setSurname(rs.getString("surname"));
	user.setEmail(rs.getString("email"));
	user.setDone(rs.getBoolean("done"));
	user.setId(rs.getInt("id"));
	return user;
}
}
