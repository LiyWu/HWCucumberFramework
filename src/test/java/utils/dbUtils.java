package utils;

//import cn.hutool.json.JSONObject;

import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;

public class dbUtils {

    public dbUtils(String env,String brand,String regulator) {


        try {
            //MySQL upgrade to 8.0
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /*jenv = ((JSONObject) JSON.parse(dbs)).getJSONObject(env.toString()).getJSONObject(this.brand.toString());

        //For AWS brand, change alpha DB url to AWS
        if(Arrays.asList(awsBrands).contains(this.brand)) {
            alphaDB_url = "jdbc:mysql://db01.crm-alpha.com:3306/";
        };*/

    }

//    public static void main(String args[]) {
//        /*
//         * DbUtils obj = new DbUtils(ENV.ALPHA,BRAND.VFX,REGULATOR.VFSC2); String sql =
//         * "select U.id as userId, M.status as wcStatus, I.status as idStatus,AP.status as addrStatus,E.vars as vars from tb_user U left join tb_account_mt4 M on U.id = M.user_id left join tb_id_proof I on U.id = I.user_id left join tb_address_proof AP on U.id = AP.user_id left join tb_mail_send_log E on U.email = E.to_mail and E.template_invoke_name = \"welcome_mail\"\r\n"
//         * + " where U.email = \"YvAxqWy6wUYwMrIabQmDkA==\" and U.is_del!=1";
//         *
//         */
//        DbUtils obj = new DbUtils(ENV.PROD,BRAND.MO,REGULATOR.VFSC);
//        String sql = "select+vars+from+tb_mail_send_log+where+template_invoke_name+like+\'verification_code\'+and+vars+like+\'%25Test+CRM%25\'+order+by+create_time+desc+limit+1%3B";
//
//        JSONObject value = obj.queryRegulatorDB(sql).getJSONObject(0);
//        System.out.println(value.toJSONString());
//        System.out.println(value.getIntValue("addrStatus"));
//		/*JSONArray js = obj.queryRegulatorDB(sql);
//		for(int i = 0; i< js.size();i++) {
//			JSONObject tt = js.getJSONObject(i);
//			System.out.println(tt.get("id"));
//		}*/
//    }
//
//    private void initialDBcon() {
//        if(this.env.compareTo(ENV.ALPHA)==0) {
//            //String conStrg = alphaDB_url+getGlobalDB()+"?autoReconnect=true&useSSL=false";
//            String conStrg = alphaDB_url+getGlobalDB()+"?useUnicode=true&characterEncoding=utf8&autoReconnect=true";
//            if(this.g_connect==null) {
//                try {
//                    g_connect = DriverManager.getConnection(conStrg, this.alphaUser, this.alphaPass);
//                } catch (SQLException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//
//            if(this.r_connect==null && this.getRegulatorDB()!=null) {
//                String conStrr = alphaDB_url+getRegulatorDB()+"?autoReconnect=true&useSSL=false";
//                try {
//                    r_connect = DriverManager.getConnection(conStrr, this.alphaUser, this.alphaPass);
//                } catch (SQLException e) {
//                    // 	TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }else {
//
//            //If brands in awsBrands list
//            if (Arrays.asList(awsBrands).contains(this.brand)){
//                if (this.awsdb == null) {
//                    awsdb = new AwsDb();
//                }
//                return;
//            }
//
//            if(this.token==null) {
//                try {
//                    this.token = RestAPI.getTianyitechsToken();
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//                headerMap = new HashMap<>();
//                headerMap.put("Content-Type", "application/json;charset=UTF-8");
//                headerMap.put("Accept", "*/*");
//                headerMap.put("WWW-Authenticate", "Token");
//                headerMap.put("Authorization", "Token "+this.token);
//            }
//        }
//    }
//
//    /**
//     *  将alpha数据库返回的结果集统一封装为JSONArray
//     * @param rl alpha数据库返回的结果集
//     * @return 封装好的JSONArray
//     */
//    private JSONArray formatResult(ResultSet rl) {
//        JSONArray jsonarray = new JSONArray();
//        try {
//            ResultSetMetaData metaData = rl.getMetaData();
//            int column = metaData.getColumnCount();
//
//            while(rl.next()) {
//                String result = "{";
//                for(int i = 1;i <=column; i++) {//ResultSet第一列的初始index是1，不是0
//                    String value = rl.getString(i);
//                    //处理字符串中对于JSON是特殊字符的字符
//                    if(value !=null && JSONValidator.from(value).validate()) {
//                        result = result +"\"" + metaData.getColumnLabel(i)+"\":"+value+",";
//                    }else {
//                        if(value!=null) {
//                            value = value.replace("\\", "\\\\");
//                        }
//                        result = result +"\"" + metaData.getColumnLabel(i)+"\":\""+value+"\",";
//                    }
//                }
//                result = result.substring(0, result.lastIndexOf(",")) + "}";
//                jsonarray.add(JSON.parse(result));
//            }
//        }catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return jsonarray;
//        }
//        return jsonarray;
//    }
//
//    /**
//     * 查询线上数据库
//     * @param global true查询global，false查询监管库
//     * @param sql
//     * @return
//     */
//    private JSONArray queryProdDB(Boolean global,String sql) {
//
//        //for AWS db
//        if(Arrays.asList(awsBrands).contains(this.brand)) {
//
//            String instance = getProdInstance();
//            String schema = "";
//            if(global) {
//                schema = this.getGlobalDB();
//            }else {
//                schema = this.getRegulatorDB();
//            }
//
//            return this.awsdb.query(instance, schema, sql);
//        }
//
//
//        String dbNo;
//        String fullPath;
//        JSONObject post = new JSONObject();
//        post.put("sql", sql);
//        if(global) {
//            dbNo = this.getGlobalDB();
//        }else {
//            dbNo = this.getRegulatorDB();
//        }
//        fullPath = this.url + dbNo + "/";
//
//        //System.out.println("fullPath:"+fullPath);
//        String result = null;
//        try {
//            result = RestAPI.commonPostAPI(fullPath,headerMap,post.toJSONString());
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        if(result != null) {
//            JSONObject ro = JSON.parseObject(result);
//            return ro.getJSONArray("data");
//        }
//
//        return new JSONArray();
//    }
//
//    /**
//     * 查询alpha global数据库
//     * @param sql 需要执行的SQL字符串
//     * @return
//     */
//    public JSONArray queryGlobalDB(String sql) {
//        initialDBcon();
//        JSONArray jsonarray = new JSONArray();
//        if(env.compareTo(ENV.ALPHA)==0) {
//            try {
//                Statement stt = g_connect.createStatement();
//
//                ResultSet rl = stt.executeQuery(sql);
//                jsonarray = formatResult(rl);
//                rl.close();
//                stt.close();
//                return jsonarray;
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//                return jsonarray;
//            }
//        }else {
//            return queryProdDB(true,sql);
//        }
//    }
//
//    /**
//     * 更新alpha数据库的表
//     * @param sql 需要执行的SQL
//     * @return 返回影响行数
//     */
//    public int updateRegulatorDB(String sql) {
//        initialDBcon();
//        if(env.equals(ENV.PROD)) {
//            return -1;
//        }
//        try {
//            Statement stt = r_connect.createStatement();
//            int result =  stt.executeUpdate(sql);
//            stt.close();
//            return result;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return -1;
//        }
//    }


}
