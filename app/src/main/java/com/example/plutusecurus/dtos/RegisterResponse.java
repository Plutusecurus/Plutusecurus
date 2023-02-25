package com.example.plutusecurus.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class RegisterResponse {

    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("user")
    private User user;
    @Expose
    @SerializedName("success")
    private boolean success;
    @Expose
    @SerializedName("code")
    private int code;

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class User {
        @Expose
        @SerializedName("__v")
        private int __v;
        @Expose
        @SerializedName("_id")
        private String _id;
        @Expose
        @SerializedName("spending")
        private Spending spending;
        @Expose
        @SerializedName("earning")
        private int earning;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("account")
        private String account;
        @Expose
        @SerializedName("profilePic")
        private String profilePic;

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
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

        public int getEarning() {
            return earning;
        }

        public void setEarning(int earning) {
            this.earning = earning;
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
    }

    public static class Spending {
        @Expose
        @SerializedName("misc")
        private int misc;
        @Expose
        @SerializedName("gifts")
        private int gifts;
        @Expose
        @SerializedName("luxury")
        private int luxury;
        @Expose
        @SerializedName("transport")
        private int transport;
        @Expose
        @SerializedName("medical")
        private int medical;
        @Expose
        @SerializedName("food")
        private int food;
        @Expose
        @SerializedName("housing")
        private int housing;
        @Expose
        @SerializedName("essentials")
        private int essentials;

        public int getMisc() {
            return misc;
        }

        public void setMisc(int misc) {
            this.misc = misc;
        }

        public int getGifts() {
            return gifts;
        }

        public void setGifts(int gifts) {
            this.gifts = gifts;
        }

        public int getLuxury() {
            return luxury;
        }

        public void setLuxury(int luxury) {
            this.luxury = luxury;
        }

        public int getTransport() {
            return transport;
        }

        public void setTransport(int transport) {
            this.transport = transport;
        }

        public int getMedical() {
            return medical;
        }

        public void setMedical(int medical) {
            this.medical = medical;
        }

        public int getFood() {
            return food;
        }

        public void setFood(int food) {
            this.food = food;
        }

        public int getHousing() {
            return housing;
        }

        public void setHousing(int housing) {
            this.housing = housing;
        }

        public int getEssentials() {
            return essentials;
        }

        public void setEssentials(int essentials) {
            this.essentials = essentials;
        }
    }
}
