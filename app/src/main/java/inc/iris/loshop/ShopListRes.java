package inc.iris.loshop;

/**
 * Created by Sabita_Sant on 8/29/2017.
 */
public class ShopListRes {

    int shop_icon;
    String shop_name, shop_cat, shop_time, shop_offday;

    public ShopListRes(int shop_icon, String shop_name, String shop_cat, String shop_time, String shop_offday) {
        this.shop_icon = shop_icon;
        this.shop_name = shop_name;
        this.shop_cat = shop_cat;
        this.shop_time = shop_time;
        this.shop_offday = shop_offday;
    }

    public int getShop_icon() {
        return shop_icon;
    }

    public String getShop_name() {
        return shop_name;
    }

    public String getShop_cat() {
        return shop_cat;
    }

    public String getShop_time() {
        return shop_time;
    }

    public String getShop_offday() {
        return shop_offday;
    }

}
