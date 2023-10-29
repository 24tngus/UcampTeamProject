package com.mission.mymission.repository;

import com.mission.mymission.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ReserveRepository extends JpaRepository<Reserve, Integer> {

    List<Reserve> findByStoreid(String id);
    List<Reserve> findByReserver(String reserver);
    Reserve findBySeq(int seq);
    Reserve save(Reserve reserve);

    @Query("SELECT SUM(r.people) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time0810 = :time0810")
    Integer findSumPeopleByParams0810Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time0810") int time0810);

    @Query("SELECT SUM(r.team) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time0810 = :time0810")
    Integer findSumTeamByParams0810Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time0810") int time0810);

    @Query("SELECT SUM(r.people) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time1012 = :time1012")
    Integer findSumPeopleByParams1012Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time1012") int time1012);

    @Query("SELECT SUM(r.team) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time1012 = :time1012")
    Integer findSumTeamByParams1012Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time1012") int time1012);

    @Query("SELECT SUM(r.people) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time1214 = :time1214")
    Integer findSumPeopleByParams1214Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time1214") int time1214);

    @Query("SELECT SUM(r.team) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time1214 = :time1214")
    Integer findSumTeamByParams1214Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time1214") int time1214);

    @Query("SELECT SUM(r.people) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time1416 = :time1416")
    Integer findSumPeopleByParams1416Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time1416") int time1416);

    @Query("SELECT SUM(r.team) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time1416 = :time1416")
    Integer findSumTeamByParams1416Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time1416") int time1416);

    @Query("SELECT SUM(r.people) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time1618 = :time1618")
    Integer findSumPeopleByParams1618Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time1618") int time1618);

    @Query("SELECT SUM(r.team) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time1618 = :time1618")
    Integer findSumTeamByParams1618Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time1618") int time1618);

    @Query("SELECT SUM(r.people) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time1820 = :time1820")
    Integer findSumPeopleByParams1820Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time1820") int time1820);

    @Query("SELECT SUM(r.team) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time1820 = :time1820")
    Integer findSumTeamByParams1820Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time1820") int time1820);

    @Query("SELECT SUM(r.people) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time2022 = :time2022")
    Integer findSumPeopleByParams2022Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time2022") int time2022);

    @Query("SELECT SUM(r.team) FROM Reserve r where r.storeid = :storeid AND r.date = :date AND r.time2022 = :time2022")
    Integer findSumTeamByParams2022Reserve(@Param("storeid") String storeid, @Param("date") Date date, @Param("time2022") int time2022);


}
