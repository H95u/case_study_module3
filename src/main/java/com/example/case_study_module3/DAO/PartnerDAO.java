package com.example.case_study_module3.DAO;

import com.example.case_study_module3.DAO.connection.MyConnection;
import com.example.case_study_module3.model.Partner;
import com.example.case_study_module3.model.User;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PartnerDAO {
    private Connection connection = MyConnection.getConnection();
    private static PartnerDAO partnerDAO;

    public static PartnerDAO getInstance() {
        if (partnerDAO == null) {
            partnerDAO = new PartnerDAO();
        }
        return partnerDAO;
    }

    public List<Partner> findAll() {
        List<Partner> partnerList = new ArrayList<>();
        String querry = "select * from partner";
        try (PreparedStatement preparedStatement = connection.prepareStatement(querry)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nickname = resultSet.getString("nickname");
                double hourlyRate = resultSet.getDouble("hourly_rate");
                int availability = resultSet.getInt("availability");
                LocalDate dob = resultSet.getDate("dob").toLocalDate();
                String address = resultSet.getString("address");
                int gender = resultSet.getInt("gender");
                Blob imageBlob = resultSet.getBlob("image");
                InputStream imageStream;
                if (imageBlob != null) {
                    imageStream = imageBlob.getBinaryStream();
                    byte[] imageBytes = imageStream.readAllBytes();
                    partnerList.add(new Partner(id, null, null, nickname,
                            hourlyRate, availability, imageBytes, dob, address, gender));
                } else {
                    partnerList.add(new Partner(id, null, null, nickname,
                            hourlyRate, availability, null, dob, address, gender));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return partnerList;
    }

    public Partner findById(int id) {
        Partner partner = null;
        String querry = "select * from partner where id = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(querry)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nickname = resultSet.getString("nickname");
                double hourlyRate = resultSet.getDouble("hourly_rate");
                int availability = resultSet.getInt("availability");
                LocalDate dob = resultSet.getDate("dob").toLocalDate();
                String address = resultSet.getString("address");
                int gender = resultSet.getInt("gender");
                Blob imageBlob = resultSet.getBlob("image");
                InputStream imageStream;
                if (imageBlob != null) {
                    imageStream = imageBlob.getBinaryStream();
                    byte[] imageBytes = imageStream.readAllBytes();
                    partner = new Partner(id, null, null, nickname,
                            hourlyRate, availability, imageBytes, dob, address, gender);
                } else {
                    partner = new Partner(id, null, null, nickname,
                            hourlyRate, availability, null, dob, address, gender);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return partner;
    }
    public void uploadImage(InputStream fileContent, int id) {
        String querry = "update partner set image = ?  where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(querry)) {
            preparedStatement.setBinaryStream(1, fileContent);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
