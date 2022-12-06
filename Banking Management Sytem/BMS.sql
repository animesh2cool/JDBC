use Anudip;
create table Bank (account_no int(10) primary key auto_increment, 
					account_holder varchar(20), 
                    ifsc_code varchar(20), 
                    branch varchar(10), 
					account_type varchar(10), 
                    balance numeric(12,2), 
                    pin numeric(4));