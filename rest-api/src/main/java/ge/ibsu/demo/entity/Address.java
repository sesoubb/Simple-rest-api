package ge.ibsu.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_address_id_seq", sequenceName = "address_address_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_address_id_seq")
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address")
    private String address;

    @Column(name = "district")
    private String district;

    @Column(name = "phone")
    private String phone;
    @JoinColumn(name = "city_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
