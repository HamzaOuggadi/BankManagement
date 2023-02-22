package ma.atos.ma.atos.bankmanagement.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIER_TYPE")
@Table(name = "Tier", uniqueConstraints =
        {@UniqueConstraint( columnNames = {"numClient"})})
public abstract class Tier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idClient;
    private String numClient;
    protected String nationalite;
    protected Date dateSouscription;
    protected String adresse;
    @OneToMany(mappedBy = "tier")
    private List<Compte> comptes;
    @OneToMany
    protected List<Restriction> restrictions;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNumClient() {
        return numClient;
    }

    public void setNumClient(String numClient) {
        this.numClient = numClient;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public Date getDateSouscription() {
        return dateSouscription;
    }

    public void setDateSouscription(Date dateSouscription) {
        this.dateSouscription = dateSouscription;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<Restriction> restrictions) {
        this.restrictions = restrictions;
    }
}
