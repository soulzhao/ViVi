INSERT INTO vivi.T_Membertype VALUES 
('402882c65977a8e3015979144c980007','2017-01-07',NULL,'VIP会员',NULL,NULL,'VIP'),
('ff8080815a0317ae015a04538a900000','2017-02-03',NULL,'普通会员',NULL,NULL,'normal');

INSERT INTO vivi.T_Member VALUES ('402882c65977a8e3015979314d8c0009','郭新东路199号','2017-01-01','2017-01-07',NULL,0,'soulzx2010@gmail.com','打篮球','程序员',NULL,'2017-01-07','赵翔','1510001312','','好人','M','TTTTTTT','402882c65977a8e3015979144c980007');

INSERT INTO vivi.T_Producttype VALUES ('402882c659779d030159779dcbf80000',NULL,NULL,'产品类别1',NULL,NULL,'CPLB1'),('402882c65977a8e301597918b4bf0008',NULL,NULL,'产品类别2',NULL,NULL,'CPLB2');

INSERT INTO vivi.T_Product VALUES 
('402882c659779d030159779e44150001',0,0,'2017-01-07',NULL,0,'产品1',NULL,'2017-01-09','产品1','CP1',NULL,0,10,'次','402882c659779d030159779dcbf80000'),
('402882c659779d030159779e65ef0002',1,0,'2017-01-07',NULL,0,'产品2',NULL,'2017-01-09','产品2','CP2',NULL,0,20,'次','402882c659779d030159779dcbf80000');

INSERT INTO vivi.T_ProductPackage VALUES 
('402882c65977a8e3015977b346ed0000',1,'2017-01-07',NULL,0,'套餐1','2017-01-31 00:00:00','2017-01-01 00:00:00','','2017-01-09','套餐1','TC1',110),
('402882c65977a8e3015977b46b120002',1,'2017-01-07',NULL,0,'套餐2','2017-01-31 00:00:00','2017-01-01 00:00:00','','2017-01-09','套餐2','TC2',120);

INSERT INTO vivi.T_PackageMapping VALUES 
('2c90808759815d4c0159815eb5e10000',1,'402882c659779d030159779e44150001','402882c65977a8e3015977b346ed0000'),
('2c90808759815d4c0159815ecd790001',2,'402882c659779d030159779e44150001','402882c65977a8e3015977b46b120002'),
('2c90808759815d4c0159815ecd790002',6,'402882c659779d030159779e65ef0002','402882c65977a8e3015977b46b120002');

INSERT INTO vivi.T_Vender VALUES ('1','苏州市工业园区环球188','viva',NULL,NULL,0,'美容','viva天玺媛美容');

INSERT INTO vivi.T_ProductDiscount VALUES 
('402881e759f851a50159f852e4550000','2017-02-01 14:18:19',NULL,0.8,NULL,'2017-02-01 14:18:19','402882c65977a8e3015979144c980007','402882c659779d030159779e44150001',NULL);

INSERT INTO vivi.T_Systemconfig VALUES 
('402882c65977a8e3015979144c980000','&equal;',NULL,'GLOBAL-DEPOSIT-BONUS_RATE','*','全局积分百分比','默认为0','0','2017-01-07 00:00:00','2017-01-07 00:00:00'),
('402882c65977a8e3015979144c980001','&equal;402882c65977a8e3015979144c980007','null','MT-DEPOSIT-BONUS_RATE','SALE','会员类型积分百分比','VIP会员类别的积分百分比','0.1','2017-01-07 00:00:00','2017-01-07 00:00:00'),
('402882c65977a8e3015979144c980002','6800','MEMBER_TYPE','DEPOSIT-MEMBER_TYPE','MEMBER','银卡会员充值门槛','充值大于6800自动变为VIP会员','402882c65977a8e3015979144c980007','2017-01-07 00:00:00','2017-01-07 00:00:00');
