Running `./gradlew run` within a terminal show the following issue for both (ir, legacy) backend. However, the detailed message could look a bit different for each case:

```
# kotlin.js.compiler=legacy

> Task :nodeRun FAILED                                                                                                                                                                                                                                                                                          
Starting TaskApp                                                                                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                                                                                
/anywhere/kotlin-js-es6-inheritance/src/main/kotlin/Main.kt:3                                                                                                                                                                                                                               
class TaskApp: App () {                                                                                                                                                                                                                                                                                         
               ^                                                                                                                                                                                                                                                                                                
TypeError: Class constructor App cannot be invoked without 'new'   
```

Information

1. The [nvmrc](.nvmrc) file can be used to create a local environment using `nvm install` or `nvm use`, but it is not a requirement.
2. A sample [npm project](./app) containing an es6 class export is linked as dependency and will be present in the node_modules build directory.
3. The actual kotlin definition has been created with dukat (`./gradlew generateExternals`). The content has then been manually [copied](./src/main/dukat) and enhanced with a *file:JsModule* annotation at package level. 
   It would otherwise not create the needed `require('app')` statement.
