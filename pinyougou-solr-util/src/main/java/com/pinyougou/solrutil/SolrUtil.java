package com.pinyougou.solrutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import com.pinyougou.pojo.TbItemExample.Criteria;

@Component
public class SolrUtil {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private SolrTemplate solrTemplate;
	
	public void importItemData(){
		
		TbItemExample example=new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("1");//审核通过的才导入的
		List<TbItem> itemList = itemMapper.selectByExample(example);
		
		System.out.println("---商品列表---");
		for(TbItem item:itemList){
			System.out.println(item.getId()+" "+ item.getTitle()+ " "+item.getPrice());	
			Map specMap = JSON.parseObject(item.getSpec(), Map.class);//从数据库中提取规格json字符串转换为map
			item.setSpecMap(specMap);
		}
		
		solrTemplate.saveBeans(itemList);
		solrTemplate.commit();
		
		System.out.println("---结束---");
	}
	
	public static void main(String[] args) {
		
		/*ApplicationContext context=new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml");
		SolrUtil solrUtil=  (SolrUtil) context.getBean("solrUtil");
		solrUtil.importItemData();*/
		SolrUtil su = new SolrUtil();
		su.getGrayCode(2);
	}
	public List<Integer> getGrayCode(int bitNum){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < (int)Math.pow(2, bitNum); i++){
			 int grayCode = (i >> 1) ^ i;

			String str = Integer.valueOf(num2Binary(grayCode, bitNum),2).toString();
			 list.add(Integer.parseInt(str));
			 System.out.println(str);
 		}
 		return list;
	}
	public String num2Binary(int num, int bitNum){
		String ret = "";
		for(int i = bitNum-1; i >= 0; i--){
			ret += (num >> i) & 1;
		}
 		return ret;
 	}
	
}
