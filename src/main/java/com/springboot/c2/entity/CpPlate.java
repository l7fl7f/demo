package com.springboot.c2.entity;

public class CpPlate extends Entity<Integer> {
    private Integer id;
    private String cpId;
    private String plate;
    private String channel;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "CpPlate{" +
                "id=" + id +
                ", cpId='" + cpId + '\'' +
                ", plate='" + plate + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }
}
