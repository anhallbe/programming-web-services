/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw1.dom;

import java.util.Date;
import java.util.List;

/**
 *
 * @author andreas
 */
public class CV {
        private String surName, lastName, address, city, country, phone, email, about;
        private Date birthDate;
        private List<Reference> references;

        @Override
        public String toString() {
            String result = "";
            result += "surname: " + surName;
            result += "\nlastname: " + lastName;
            result += "\naddress: " + address;
            result += "\ncity: " + city;
            result += "\ncountry: " + country;
            result += "\nphone: " + phone;
            result += "\nemail: " + email;
            result += "\nabout: " + about;
            result += "\nbirthdate: " + birthDate;
            result += "\nreferences: ";
            for(Reference ref : references) {
                result += "\n------------";
                result += "\n" + ref.getName();
                result += "\n" + ref.getAbout();
                result += "\n" + ref.getContactInfo();
            }
            return result;
        }
        
        public String getSurName() {
            return surName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }

        public String getAbout() {
            return about;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public List<Reference> getReferences() {
            return references;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setReferences(List<Reference> references) {
            this.references = references;
        }

        public void setSurName(String surName) {
            this.surName = surName;
        }
    }