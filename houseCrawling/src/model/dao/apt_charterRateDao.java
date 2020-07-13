package model.dao;

import model.dto.apt_charterRate;
import model.dto.apt_riseRate;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class apt_charterRateDao {

    public void saveCharterRate(apt_charterRate dto) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DBUtil.getConnection();
            StringBuilder sql = new StringBuilder(100);

            sql.append("insert into my_crwaling.apt_charterRate (bun, rank,location,name,apt_charterRate,gap,salePrice,charter) \n");
            sql.append("values (?, ?, ?, ?, ?, ?, ?, ?)");

            //System.out.println(dto.getRank());
            //System.out.println(sql.toString());

            stmt = con.prepareStatement(sql.toString());
            stmt.setString(1, dto.getBun());
            stmt.setString(2, dto.getRank());
            stmt.setString(3, dto.getLocation());
            stmt.setString(4, dto.getName());
            stmt.setString(5, dto.getApt_charterRate());
            stmt.setString(6, dto.getGap());
            stmt.setString(7, dto.getSalePrice());
            stmt.setString(8, dto.getCharter());
            stmt.executeUpdate();

        } finally {
            DBUtil.close(stmt);
            DBUtil.close(con);
        }
    }
}
