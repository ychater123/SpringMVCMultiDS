package org.o7planning.springmvcmultids.dao;
 
import java.util.List;
 
import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
 
@Repository
public class DataDAO extends JdbcDaoSupport {
 
    @Autowired
    public DataDAO(DataSource dataSource) {
    	this.setDataSource(dataSource);
    }
 
    public List<String> queryPublishers() {
        String sql = "select name from publishers";
 
        List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
        return list;
    }
 
    public List<String> queryAdvertisers() {
        String sql = "select name from advertisers";
 
        List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
        return list;
    }
    
}