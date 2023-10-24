package com.mission.mymission.repository;

import com.mission.mymission.entity.Reservesetting;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ReservesettingRepository extends JpaRepository<com.mission.mymission.entity.Reservesetting, Integer> {
    @Transactional
    @Modifying
    @Query("update Reservesetting r set r.team = :team, r.people = :people, r.date = :date, r.time0810 = :time0810, r.time1012 = :time1012, r.time1214 = :time1214, r.time1416 = :time1416, r.time1618 = :time1618, r.time1820 = :time1820, r.time2022 = :time2022 where r.seq = :seq")
    void updateReservesetting(@Param("seq") int seq, @Param("team") int team, @Param("people") int people, @Param("date") Date date,
                              @Param("time0810") int time0810, @Param("time1012") int time1012, @Param("time1214") int time1214
            , @Param("time1416") int time1416, @Param("time1618") int time1618, @Param("time1820") int time1820
            , @Param("time2022") int time2022);

    Reservesetting save(Reservesetting reservesetting);

    List<Reservesetting> findByShopseqAndDate(int shopseq, Date date);

    @Query("SELECT SUM(r.people) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time0810 = :time0810")
    int findSumPeopleByParams0810(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time0810") int time0810);
    @Query("SELECT SUM(r.team) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time0810 = :time0810")
    int findSumTeamByParams0810(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time0810") int time0810);

    @Query("SELECT SUM(r.people) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time1012 = :time1012")
    int findSumPeopleByParams1012(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time1012") int time1012);
    @Query("SELECT SUM(r.team) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time1012 = :time1012")
    int findSumTeamByParams1012(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time1012") int time1012);

    @Query("SELECT SUM(r.people) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time1214 = :time1214")
    int findSumPeopleByParams1214(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time1214") int time1214);
    @Query("SELECT SUM(r.team) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time1214 = :time1214")
    int findSumTeamByParams1214(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time1214") int time1214);

    @Query("SELECT SUM(r.people) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time1416 = :time1416")
    int findSumPeopleByParams1416(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time1416") int time1416);
    @Query("SELECT SUM(r.team) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time1416 = :time1416")
    int findSumTeamByParams1416(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time1416") int time1416);

    @Query("SELECT SUM(r.people) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time1618 = :time1618")
    int findSumPeopleByParams1618(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time1618") int time1618);
    @Query("SELECT SUM(r.team) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time1618 = :time1618")
    int findSumTeamByParams1618(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time1618") int time1618);

    @Query("SELECT SUM(r.people) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time1820 = :time1820")
    int findSumPeopleByParams1820(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time1820") int time1820);
    @Query("SELECT SUM(r.team) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time1820 = :time1820")
    int findSumTeamByParams1820(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time1820") int time1820);

    @Query("SELECT SUM(r.people) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time2022 = :time2022")
    int findSumPeopleByParams2022(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time2022") int time2022);
    @Query("SELECT SUM(r.team) FROM Reservesetting r WHERE r.shopseq = :shopseq AND r.date = :date AND r.time2022 = :time2022")
    int findSumTeamByParams2022(@Param("shopseq") int shopseq, @Param("date") Date date, @Param("time2022") int time2022);
}