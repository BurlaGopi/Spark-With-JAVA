// Databricks notebook source
// MAGIC %scala
// MAGIC spark.conf.set("fs.azure.account.key.adlgen3.dfs.core.windows.net","xA4BP5wLytEDIs83mvqr+JKT43QbiMlReH/EofX31123qzyroTHGoAeQrsli/SURN8FMfFnKGtnE+AStKjj86Q==")
// MAGIC

// COMMAND ----------

// MAGIC %scala
// MAGIC import org.apache.spark.sql.functions._
// MAGIC val df1=spark.read.option("header",true).format("csv").load("abfss://rawdata@adlgen3.dfs.core.windows.net/electricity-normalized.csv")
// MAGIC val df2=df1.withColumn("newcol",expr("case when class='UP' then vicprice "+ "else nswprice*2 end"))
// MAGIC df2.show()
// MAGIC

// COMMAND ----------

val jdbchostname="databricksdatabase.database.windows.net"
val jdbcport=1433
val jdbcdatabase="azuresqldatabase"

val jdbcurl=s"jdbc:sqlserver://${jdbchostname}:${jdbcport};databasename=${jdbcdatabase}"
import java.util.Properties
val connectionproperties=new Properties()
connectionproperties.put("user","databricksdatabase")
connectionproperties.put("password","Gopii@123")


// COMMAND ----------

df2.write.jdbc(jdbcurl,"electdata",connectionproperties)

// COMMAND ----------


