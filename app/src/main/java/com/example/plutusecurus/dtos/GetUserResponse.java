package com.example.plutusecurus.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUserResponse {


    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("user")
    private User user;
    @Expose
    @SerializedName("success")
    private boolean success;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class User {
        @Expose
        @SerializedName("__v")
        private int __v;
        @Expose
        @SerializedName("earning")
        private double earning;
        @Expose
        @SerializedName("upiID")
        private String upiID;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("account")
        private String account;
        @Expose
        @SerializedName("profilePic")
        private String profilePic;
        @Expose
        @SerializedName("_id")
        private String _id;
        @Expose
        @SerializedName("spending")
        private Spending spending;

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public double getEarning() {
            return earning;
        }

        public void setEarning(double earning) {
            this.earning = earning;
        }

        public String getUpiID() {
            return upiID;
        }

        public void setUpiID(String upiID) {
            this.upiID = upiID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getProfilePic() {
            return profilePic;
        }

        public void setProfilePic(String profilePic) {
            this.profilePic = profilePic;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public Spending getSpending() {
            return spending;
        }

        public void setSpending(Spending spending) {
            this.spending = spending;
        }
    }

    public static class Spending {
        @Expose
        @SerializedName("misc")
        private double misc;
        @Expose
        @SerializedName("gifts")
        private double gifts;
        @Expose
        @SerializedName("luxury")
        private double luxury;
        @Expose
        @SerializedName("transport")
        private double transport;
        @Expose
        @SerializedName("medical")
        private double medical;
        @Expose
        @SerializedName("food")
        private double food;
        @Expose
        @SerializedName("housing")
        private double housing;
        @Expose
        @SerializedName("essentials")
        private double essentials;

        public double getMisc() {
            return misc;
        }

        public void setMisc(double misc) {
            this.misc = misc;
        }

        public double getGifts() {
            return gifts;
        }

        public void setGifts(double gifts) {
            this.gifts = gifts;
        }

        public double getLuxury() {
            return luxury;
        }

        public void setLuxury(double luxury) {
            this.luxury = luxury;
        }

        public double getTransport() {
            return transport;
        }

        public void setTransport(double transport) {
            this.transport = transport;
        }

        public double getMedical() {
            return medical;
        }

        public void setMedical(double medical) {
            this.medical = medical;
        }

        public double getFood() {
            return food;
        }

        public void setFood(int food) {
            this.food = food;
        }

        public double getHousing() {
            return housing;
        }

        public void setHousing(double housing) {
            this.housing = housing;
        }

        public double getEssentials() {
            return essentials;
        }

        public void setEssentials(double essentials) {
            this.essentials = essentials;
        }
    }
}
