package model.dao;

import model.dto.apt_charterRate;
import model.dto.apt_riseRate;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class apt_riseRateDao {

    public void saveRiseRate(apt_riseRate dto) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DBUtil.getConnection();
            StringBuilder sql = new StringBuilder(100);

            sql.append("insert into my_crwaling.apt_riseRate (bun,rank,location,name,ascent,riseRate,before_date,now_date) \n");
            sql.append("values (?, ?, ?, ?, ?, ? ,? ,?)");

            //System.out.println(sql.toString());

            stmt = con.prepareStatement(sql.toString());
            stmt.setString(1, dto.getBun());
            stmt.setString(2, dto.getRank());
            stmt.setString(3, dto.getLocation());
            stmt.setString(4, dto.getName());
            stmt.setString(5, dto.getAscent());
            stmt.setString(6, dto.getRiseRate());
            stmt.setString(7, dto.getBefore_date());
            stmt.setString(8, dto.getNow_date());
            stmt.executeUpdate();



        } finally {
            DBUtil.close(stmt);
            DBUtil.close(con);
        }
    }
}
