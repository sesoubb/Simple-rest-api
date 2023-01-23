package ge.ibsu.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @SequenceGenerator(name = "city_city_id_seq", sequenceName = "city_city_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_city_id_seq")
    @Column(name = "city_id")
    private long cityId;

    @Column(name = "city")
    private String cityName;

    @Column(name = "country_id")
    private int countryId;

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
