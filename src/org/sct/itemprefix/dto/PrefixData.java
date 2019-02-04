package org.sct.itemprefix.dto;

/**
 * 数据储存类
 *
 * @author SCT_Alchemy
 * @date 2019/2/2 10:57 PM
 */

public class PrefixData {

    String prefix;
    String item;

    @Override
    public String toString() {
        return "PrefixData{" +
                "prefix='" + prefix + '\'' +
                ", item='" + item + '\'' +
                '}';
    }

    public PrefixData(String prefix, String item) {
        this.prefix = prefix;
        this.item = item;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getItem() {
        return item;
    }

}
