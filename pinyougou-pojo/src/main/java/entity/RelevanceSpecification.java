package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RelevanceSpecification implements Serializable {
    List<Map> data = new ArrayList<>();

    public RelevanceSpecification() {
    }

    @Override
    public String toString() {
        return "RelevanceSpecification{" +
                "data=" + data +
                '}';
    }

    public List<Map> getData() {
        return data;
    }

    public void setData(List<Map> data) {
        this.data = data;
    }

    public RelevanceSpecification(List<Map> data) {

        this.data = data;
    }
}
