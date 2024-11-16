import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class HWTest {

    public static void main(String[] args) throws IOException {


        try {
            String filePath = System.getProperty("user.dir") + "/src/main/java/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH-mm-ss-SSS")) + ".txt";
            System.out.println("filepath:" + filePath);
            FileWriter writer = new FileWriter(filePath, true);
            writer.append("Hello");
            writer.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd 'T' HH-mm-ss-SSS"))+"\n");
            writer.close();



            FileReader fr = new FileReader("/Users/helen/Desktop/Vantage2024615/HWCucumberFramework/src/main/java/helentest.json");
            JsonObject jo = JsonParser.parseReader(fr).getAsJsonObject();
            String name = jo.get("name").getAsString();
            int age = jo.get("age").getAsInt();
            System.out.println("name:" + name + "age:" + age);

        }catch (Exception e)
        {

        }
        /*Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int start = sc.nextInt();
        int end = sc.nextInt();

        String sub = s.substring(start,end);

        System.out.println(sub);*/
        HashMap<String,String> hm = new HashMap<>();
        hm.put("header","contenttype");
        hm.put("body","property");
        hm.forEach((key,value)->{
            System.out.println("key" + key + "value" + value);
        });


        /*HttpResponse loginRes = HttpRequest.post(admin_env + HyTechUrl.adminLogin)
              .form(loginParams).
                timeout(20000).
                execute();

        String jsId;
        if(loginRes.body().equals(""))
        {  jsId = loginRes.getCookie("jsId").toString();
            log.info(jsId);
            testData.put("jsId",jsId);}
    */
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";

        Response resp = RestAssured.given().header("Content-Type","application/json")
                .when().get("/posts/1");

        resp.body().jsonPath().prettyPrint();
        resp.then().assertThat().statusCode(200).body("userId",equalTo(1)).body("title",notNullValue());

        JsonPath js = new JsonPath(resp.asString());
        int statuscode = resp.statusCode();
        System.out.println("status:" + statuscode);

        String user = js.getString("userId");
        System.out.println("user" + user);


        /*RestAssured.baseURI = "https://api.example.com";

        RestAssured.given()
                .auth().basic("username", "password")
                .when()
                .get("/secure-endpoint")
                .then()
                .statusCode(200);

        RestAssured.baseURI = "https://api.example.com";

        RestAssured.given()
                .auth().oauth2("your-access-token")
                .when()
                .get("/secure-endpoint")
                .then()
                .statusCode(200);
*/

        int i = Integer.valueOf("123");
        System.out.println(i);

        System.out.println(java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("DDMMYYHHMMSS")));
        System.out.println(java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddyyyyHHmmss")));

        String s = "3567";
            char[] arr = s.toCharArray();
            int[] intss = new int[arr.length];
            int count = 0;
            int result = 0;
            for(char c:arr)
            {
                if(c>='0' && c <='9')
                {
                    intss[count++] = c - '0';
                    /*count++;*/
                    continue;
                }
                else {
                    System.out.println("The input is not a number");
                    return;
                }
            }

                for(int k : intss)
                {
                    System.out.println(k);
                    result = result*10+k;
                }
                System.out.println(result);


                int price[] = {1,5,3,4,6};
                int profit[] = {2,3,4,5,6};


                long lo = getMaximumProfit(price,profit);

                System.out.println("lo");

        }

    public static long getMaximumProfit2(int[] price,int[] profit)
    {
        int maxProfit = -1;
        for(int i = 0;i<price.length-2;i++)
            for(int j = i+1;j<price.length-1;j++)
                for(int k= j+1;k< price.length; k++)
                {
                    maxProfit = Math.max(maxProfit,profit[i]+profit[j]+profit[k]);
                }
        return maxProfit;
    }
        public static long getMaximumProfit(int[] price,int[] profit)
        {

            int n = price.length;

            // Arrays to store the maximum profit till index j for both left and right subarrays
            long[] leftMaxProfit = new long[n];
            long[] rightMaxProfit = new long[n];

            // Initializing the leftMaxProfit array
            for (int i = 0; i < n; i++) {
                leftMaxProfit[i] = -1;
            }

            // Initializing the rightMaxProfit array
            for (int i = 0; i < n; i++) {
                rightMaxProfit[i] = -1;
            }

            // Tracking the maximum profit from the left subarray (for i < j)
            long maxProfitSoFar = 0;
            for (int j = 1; j < n; j++) {
                for (int i = 0; i < j; i++) {
                    if (price[i] < price[j]) {
                        leftMaxProfit[j] = Math.max(leftMaxProfit[j], profit[i] + profit[j]);
                    }
                }
            }

            // Tracking the maximum profit from the right subarray (for j < k)
            maxProfitSoFar = 0;
            for (int j = n - 2; j >= 0; j--) {
                for (int k = j + 1; k < n; k++) {
                    if (price[j] < price[k]) {
                        rightMaxProfit[j] = Math.max(rightMaxProfit[j], profit[j] + profit[k]);
                    }
                }
            }

            // Finding the maximum total profit by combining both parts
            long maxTotalProfit = -1;
            for (int j = 0; j < n; j++) {
                if (leftMaxProfit[j] != -1 && rightMaxProfit[j] != -1) {
                    maxTotalProfit = Math.max(maxTotalProfit, leftMaxProfit[j] + rightMaxProfit[j] - profit[j]);
                }
            }

            return maxTotalProfit;
        }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Graph and indegree array
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Fill graph and indegree array
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int pre = prereq[1];
            graph[pre].add(course);
            indegree[course]++;
        }

        // Queue for courses with no prerequisites (indegree 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // List to maintain the order of courses
        List<Integer> courseOrder = new ArrayList<>();

        // Process the queue
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            courseOrder.add(currentCourse);

            // Reduce the indegree of the current course's neighbors
            for (int nextCourse : graph[currentCourse]) {
                indegree[nextCourse]--;

                // If indegree becomes 0, add to the queue
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // Check if we were able to complete all courses
        if (courseOrder.size() == numCourses) {
            // Convert List to array
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = courseOrder.get(i);
            }
            return result;
        } else {
            // If there is a cycle, return an empty array
            return new int[0];
        }
    }



}
