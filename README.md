# 仓库管理系统  
数据库：Mysql  

所有接口均采用JSON格式request、response

## 功能模块 
### 1.商品、商家的增删改查  
#### 数据表  

good表：包括商品重量、价格等基本信息

brand表：商家基本信息
#### 接口  
(1) 增/改接口，包括接收前端的json数据与excel上传的文件  

(2) 删除接口：提供按商品id删除和按商家id删除两种模式  

(3) 查询：按商家id查询  
### 2.商家出货包裹的统计  
#### python脚本
定时任务，每天统计系统当前日期前一天的所有销售情况并存入daily_sales、daily_total、daily_material、daily_sku这些daily表中

#### 数据表  
task表：打包的起止时间、订单状态  

pick_list表：拣货单，每个打包单的详细内容，包括所用包材和商品信息  

daily_total表：用作日统计的均值数据     

daily_material表：用作日统计商家各包材使用数量的均值数据  

daily_sku表：用作日统计商家各包裹的sku  
#### 接口  

输入：商家编号，日期区间  
    
(1) 输出：均值集合，包括以下。包裹重量的均值、包裹价值的均值、包裹中sku(所含商品的种类数)的均值、包裹中商品数目的均值  

(2) 输出：商家各包材使用数目及占比，倒序排列  

(3) 输出：商家在日期区间内的sku情况统计，包括特定sku数目下的包裹数及包裹数占比，按照占比从高到底排列  
### 3.商家销量的统计  
#### 数据表  
task表：打包的起止时间、订单状态  

pick_list表：拣货单，每个打包单的详细内容，包括所用包材和商品信息  

daily_sales表：用作日统计销量数据  
#### 接口  
输入：商家编号，日期区间  
    
(1) 输出：日期区间内该商家各商品总销量值的排名  

(2) 输出：商家在日期区间内的日发货量的集合，集合均值、最大值、最低值、中位数、标差  

## 技术选型 

   * SpringBoot
   * Mybatis
   * Mysql8
   * Navicat15
   * Python3.8
