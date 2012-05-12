package ie.cit.cloudapp;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;

@Secured("ROLE_USER")
public class JdbcPlayerRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcPlayerRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	JdbcPlayerRepository() {
		
	}
	
	public void save(Player player) {
		jdbcTemplate.update("insert into store(name, gk, rb, cb1, cb2, lb, rw, cm1, cm2, lw, st1, st2, done, owner) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				player.getName(), player.getGk(), player.getRb(), player.getCb1(), player.getCb2(), player.getLb(),player.getRw(), player.getCm1(), player.getCm2(), player.getLw(), player.getSt1(), player.getSt2(), player.isDone(), getCurrentUser());
	}
	
	public Player get(int id) {
		return jdbcTemplate.queryForObject(
				"select id, name, gk, rb, cb1, cb2, lb, rw, cm1, cm2, lw, st1, st2, done from store where id=? and owner=?", new PlayerMapper(),
				id, getCurrentUser());
	}
		
		public List<Player> getAll() {
			return jdbcTemplate.query("select id, name, gk, rb, cb1, cb2, lb, rw, cm1, cm2, lw, st1, st2, done from store where owner=?",
					new PlayerMapper(), getCurrentUser());
		}

		private String getCurrentUser() {
			return SecurityContextHolder.getContext().getAuthentication().getName();
		}
		
		public void delete(int id) {
			jdbcTemplate.update("delete from store where id=? and owner=?", id,
					getCurrentUser());
	}
		
		class PlayerMapper implements RowMapper<Player> {
			
			public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
				Player player = new Player();
				player.setName(rs.getString("name"));
				player.setGk(rs.getString("gk"));
				player.setRb(rs.getString("rb"));
				player.setCb1(rs.getString("cb1"));
				player.setCb2(rs.getString("cb2"));
				player.setLb(rs.getString("lb"));
				player.setRw(rs.getString("rw"));
				player.setCm1(rs.getString("cm1"));
				player.setCm2(rs.getString("cm2"));
				player.setLw(rs.getString("lw"));
				player.setSt1(rs.getString("st1"));
				player.setSt2(rs.getString("st2"));
				player.setDone(rs.getBoolean("done"));
				player.setId(rs.getInt("id"));
				return player;
			}
			
		}

}
