package entity;

import com.pinyougou.pojo.TbBrand;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RelevanceBrand implements Serializable {
    List<Map> data = new ArrayList<>();

    public RelevanceBrand() {
    }

    public RelevanceBrand(List<Map> data) {

        this.data = data;
    }

    public List<Map> getData() {
        return data;
    }

    public void setData(List<Map> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RelevanceBrand{" +
                "data=" + data +
                '}';
    }
}
