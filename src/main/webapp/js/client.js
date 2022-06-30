/*
 * 
 */
$(document).ready(function() {
  const api_endpoint_url = "https://us-south.dynamic-dashboard-embedded.cloud.ibm.com/daas/";
  const my_Flask_url = "http://localhost:8080/OgiriWeb";

  async function getSessionCode(){
    return document.getElementById("sessionCode").textContent;
  }

  async function initializeAPI(sessionCode){

    const api = new CognosApi({
        cognosRootURL: api_endpoint_url,
        sessionCode: sessionCode,
        initTimeout: 10000,
        node: document.getElementById('containerDivId')
      });
    return api;
  }


  async function createDashBoard(api){
    await api.initialize();
    var dashboardApi = await api.dashboard.createNew();
    return dashboardApi;
  }
  // http://flask.pocoo.org/docs/1.0/quickstart/#static-files
  function getSampleModule(){
    var sampleModule = "";
    $.ajax({
        type: "GET",
        url: my_Flask_url+"/json/CSVinfo_jp.json",
        success: function(response){
            sampleModule = response;
        },
        async: false
    });
    return sampleModule;
  }

  async function addDataSource(dashboardApi){
    sampleModule = getSampleModule();
    await dashboardApi.addSources([{
       module: sampleModule,
       name: 'Test CSV Source',
       id: 'myUniqueId789'
    }]);
    return true;
  }

  async function main() {
    var sessionCode = await getSessionCode();
    var api = await initializeAPI(sessionCode);
    var dashboardApi = await createDashBoard(api);
    var response = await addDataSource(dashboardApi);
  }
  /*
   *   実行ボタン
   */
  $("#go").click(function() {
    main();
  });
});