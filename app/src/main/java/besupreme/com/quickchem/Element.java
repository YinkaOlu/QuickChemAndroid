package besupreme.com.quickchem;

/**
 * Created by yinka_000 on 2016-08-26.
 */
public class Element {
    private String symbol;
    private String appearance;
    private String atomic_number;
    private String group;
    private String period;
    private String element_category;
    private String standard_atomic_weight;
    private String electron_configuration;
    private String per_shell;
    private String phase;
    private String melting_point;
    private String boiling_point;
    private String density;
    private String heat_of_fusion;
    private String heat_of_vaporization;
    private String molar_heat_capacity;
    private String ionization_energies;
    private String covalent_radius;
    private String crystal_structure;
    private String discovery;
    private String summary;

    public Element(String mSymbol) {
        symbol = mSymbol;
    }

    public String getSymbol() {
        String[] extractedSymbols = symbol.split(", ");
        String extractedSymbol = extractedSymbols[1];
        return extractedSymbol;
    }
    public String getName(){
        String[] extractedSymbols = symbol.split(", ");
        String extractedName = extractedSymbols[0].toUpperCase();
        return extractedName;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String mAppearance) {
        appearance = mAppearance;
    }

    public String getAtomic_number() {
        return atomic_number;
    }

    public void setAtomic_number(String mAtomic_number) {
        atomic_number = mAtomic_number;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String mGroup) {
        group = mGroup;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String mPeriod) {
        period = mPeriod;
    }

    public String getElement_category() {
        return element_category;
    }

    public void setElement_category(String mElement_category) {
        element_category = mElement_category;
    }

    public String getStandard_atomic_weight() {
        return standard_atomic_weight;
    }

    public void setStandard_atomic_weight(String mStandard_atomic_weight) {
        standard_atomic_weight = mStandard_atomic_weight;
    }

    public String getElectron_configuration() {
        return electron_configuration;
    }

    public void setElectron_configuration(String mElectron_configuration) {
        electron_configuration = mElectron_configuration;
    }

    public String getPer_shell() {
        return per_shell;
    }

    public void setPer_shell(String mPer_shell) {
        per_shell = mPer_shell;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String mPhase) {
        phase = mPhase;
    }

    public String getMelting_point() {
        return melting_point;
    }

    public void setMelting_point(String mMelting_point) {
        melting_point = mMelting_point;
    }

    public String getBoiling_point() {
        return boiling_point;
    }

    public void setBoiling_point(String mBoiling_point) {
        boiling_point = mBoiling_point;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String mDensity) {
        density = mDensity;
    }

    public String getHeat_of_fusion() {
        return heat_of_fusion;
    }

    public void setHeat_of_fusion(String mHeat_of_fusion) {
        heat_of_fusion = mHeat_of_fusion;
    }

    public String getMolar_heat_capacity() {
        return molar_heat_capacity;
    }

    public void setMolar_heat_capacity(String mMolar_heat_capacity) {
        molar_heat_capacity = mMolar_heat_capacity;
    }

    public String getIonization_energies() {
        return ionization_energies;
    }

    public void setIonization_energies(String mIonization_energies) {
        ionization_energies = mIonization_energies;
    }

    public String getCovalent_radius() {
        return covalent_radius;
    }

    public void setCovalent_radius(String mCovalent_radius) {
        covalent_radius = mCovalent_radius;
    }

    public String getCrystal_structure() {
        return crystal_structure;
    }

    public void setCrystal_structure(String mCrystal_structure) {
        crystal_structure = mCrystal_structure;
    }

    public String getDiscovery() {
        return discovery;
    }

    public void setDiscovery(String mDiscovery) {
        discovery = mDiscovery;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String mSummary) {
        summary = mSummary;
    }

    public String getHeat_of_vaporization() {
        return heat_of_vaporization;
    }

    public void setHeat_of_vaporization(String mHeat_of_vaporization) {
        heat_of_vaporization = mHeat_of_vaporization;
    }
}
