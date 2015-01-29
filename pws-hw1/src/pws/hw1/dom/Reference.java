/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.hw1.dom;

/**
 *
 * @author andreas
 */
public class Reference {
        private String name, about, contactInfo;

        public String getName() {
            return name;
        }

        public String getAbout() {
            return about;
        }

        public String getContactInfo() {
            return contactInfo;
        }
        
        public void setAbout(String about) {
            this.about = about;
        }

        public void setContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
        }

        public void setName(String name) {
            this.name = name;
        }
    }