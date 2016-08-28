package besupreme.com.quickchem;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by yinka_000 on 2016-08-27.
 */
public class PeriodicTable {
    public static final String TAG = PeriodicTable.class.getSimpleName();
    ArrayList<Element> mElements;
    ArrayList<Element> alkali_metal = new ArrayList<>();
    ArrayList<Element>  alkaline_earth_metals = new ArrayList<>();
    ArrayList<Element> lanthanide = new ArrayList<>();
    ArrayList<Element> actinide = new ArrayList<>();
    ArrayList<Element> transition_metal = new ArrayList<>();
    ArrayList<Element> post_​transition_metal = new ArrayList<>();
    ArrayList<Element> metalloid = new ArrayList<>();
    ArrayList<Element> polyatomic_nonmetal = new ArrayList<>();
    ArrayList<Element> diatomic_nonmetal = new ArrayList<>();
    ArrayList<Element> noble_gas = new ArrayList<>();

    private final int[] alkaliMetalNumbers = {3, 11, 19, 37, 55, 87};
    private final int[] alkalineEarthMetalNums = {4, 12, 20, 38, 56, 88};
    private final int[] transitionMetalNums = {
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
            72, 73, 74, 75, 76, 77, 78, 79, 80,
            104, 105, 106, 107, 108, 112
    };
    private final int[] lanthanideNums = {71, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70};
    private final int[] actinideNums = {103, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102};
    private final int[] postTranstionNum = {13, 31, 49, 50, 81, 82, 83, 84, 114};
    private final int[] metalloidNumbers = {5, 14, 32, 33, 51, 52, 85};
    private final int[] polyatomicNums = {6, 15, 16, 34};
    private final int[] diatomicNums = {1, 7,8, 9, 17, 35, 53};
    private final int[] nobleGasNums = {2, 10, 18, 36, 54, 86};

    public PeriodicTable(ArrayList<Element> mElements) {
        this.mElements = mElements;
    }

    public void printElementNames(){
        String title = "";
        for(Element element :mElements){
            title += element.getSymbol() + "\n";
        }
        Log.i(TAG, title);
    }

    public ArrayList<Element> getAlkali_metal(){
        Log.i(TAG, "Getting Alkali Metal");
        for(int i = 0; i < mElements.size(); i++){
            int atomic_number = Integer.parseInt( mElements.get(i).getAtomic_number() );
            for(int alkaliNum : alkaliMetalNumbers){
                if(atomic_number == alkaliNum){
                    Log.i(TAG, mElements.get(i).getSymbol());
                    alkali_metal.add( mElements.get(i) );
                }
            }
        }
        return alkali_metal;
    }

    public ArrayList<Element> getAlkaline_earth_metals(){
        Log.i(TAG, "Getting Alkaline Earth Metals");
        for(int i = 0; i < mElements.size(); i++){
            int atomic_number = Integer.parseInt( mElements.get(i).getAtomic_number() );
            for(int alkaliNum : alkalineEarthMetalNums){
                if(atomic_number == alkaliNum){
                    Log.i(TAG, mElements.get(i).getSymbol());
                    alkaline_earth_metals.add( mElements.get(i) );
                }
            }
        }
        return alkaline_earth_metals;
    }

    public ArrayList<Element> getTranstionMetal(){
        Log.i(TAG, "Getting Transition Metal");
        for(int i = 0; i < mElements.size(); i++){
            int atomic_number = Integer.parseInt( mElements.get(i).getAtomic_number() );
            for(int periodicNum : transitionMetalNums){
                if(atomic_number == periodicNum){
                    Log.i(TAG, mElements.get(i).getSymbol());
                    transition_metal.add( mElements.get(i) );
                }
            }
        }
        return transition_metal;
    }

    public ArrayList<Element> getLanthanide(){
        Log.i(TAG, "Getting Lanthanide");
        for(int i = 0; i < mElements.size(); i++){
            int atomic_number = Integer.parseInt( mElements.get(i).getAtomic_number() );
            for(int posNum : lanthanideNums){
                if(atomic_number == posNum){
                    Log.i(TAG, mElements.get(i).getSymbol());
                    lanthanide.add( mElements.get(i) );
                }
            }
        }
        return lanthanide;
    }

    public ArrayList<Element> getActinide(){
        Log.i(TAG, "Getting Actinide");
        for(int i = 0; i < mElements.size(); i++){
            int atomic_number = Integer.parseInt( mElements.get(i).getAtomic_number() );
            for(int posNum : actinideNums){
                if(atomic_number == posNum){
                    Log.i(TAG, mElements.get(i).getSymbol());
                    actinide.add( mElements.get(i) );
                }
            }
        }
        return actinide;
    }

    public ArrayList<Element> getPost_​transition_metal(){
        Log.i(TAG, "Getting Post Transition Metal");
        for(int i = 0; i < mElements.size(); i++){
            int atomic_number = Integer.parseInt( mElements.get(i).getAtomic_number() );
            for(int posNum : postTranstionNum){
                if(atomic_number == posNum){
                    Log.i(TAG, mElements.get(i).getSymbol());
                    post_​transition_metal.add( mElements.get(i) );
                }
            }
        }
        return post_​transition_metal;
    }

    public ArrayList<Element> getMetalloid(){
        Log.i(TAG, "Getting Metalloid");
        for(int i = 0; i < mElements.size(); i++){
            int atomic_number = Integer.parseInt( mElements.get(i).getAtomic_number() );
            for(int posNum : metalloidNumbers){
                if(atomic_number == posNum){
                    Log.i(TAG, mElements.get(i).getSymbol());
                    metalloid.add( mElements.get(i) );
                }
            }
        }
        return metalloid;
    }

    public ArrayList<Element> getPolyatomic_nonmetal(){
        Log.i(TAG, "Getting Polyatomic nonmetal");
        for(int i = 0; i < mElements.size(); i++){
            int atomic_number = Integer.parseInt( mElements.get(i).getAtomic_number() );
            for(int posNum : polyatomicNums){
                if(atomic_number == posNum){
                    Log.i(TAG, mElements.get(i).getSymbol());
                    polyatomic_nonmetal.add( mElements.get(i) );
                }
            }
        }
        return polyatomic_nonmetal;
    }

    public ArrayList<Element> getDiatomic_nonmetal(){
        Log.i(TAG, "Getting Diatomic nonmetal");
        for(int i = 0; i < mElements.size(); i++){
            int atomic_number = Integer.parseInt( mElements.get(i).getAtomic_number() );
            for(int posNum : diatomicNums){
                if(atomic_number == posNum){
                    Log.i(TAG, mElements.get(i).getSymbol());
                    diatomic_nonmetal.add( mElements.get(i) );
                }
            }
        }
        return diatomic_nonmetal;
    }

    public ArrayList<Element> getNoble_gas(){
        Log.i(TAG, "Getting Noble Gas");
        for(int i = 0; i < mElements.size(); i++){
            int atomic_number = Integer.parseInt( mElements.get(i).getAtomic_number() );
            for(int posNum : nobleGasNums){
                if(atomic_number == posNum){
                    Log.i(TAG, mElements.get(i).getSymbol());
                    noble_gas.add( mElements.get(i) );
                }
            }
        }
        return noble_gas;
    }
}
