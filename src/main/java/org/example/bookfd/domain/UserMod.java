package org.example.bookfd.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserMod extends User{
    private Auth auth;
    private School school;
    private Photo photo;

    public void setUser(User user){
        setId(user.getId());
        setName(user.getName());
        setLastName(user.getLastName());
        setGender(user.getGender());
        setDateBirthday(user.getDateBirthday());
        setCityLive(user.getCityLive());
    }

    @Override
    public String toString() {
        return "UserMod{" +
                "auth=" + auth +
                ", school=" + school +
                ", photo=" + photo +
                '}';
    }
}
