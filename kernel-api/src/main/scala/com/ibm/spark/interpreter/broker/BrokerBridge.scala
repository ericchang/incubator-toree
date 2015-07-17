package com.ibm.spark.interpreter.broker

import com.ibm.spark.kernel.api.KernelLike
import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Represents the API available to the broker to act as the bridge for data
 * between the JVM and some external process.
 *
 * @param _brokerState The container of broker state to expose
 * @param _kernel The kernel API to expose through the bridge
 * @param _sparkContext The SparkContext to expose through the bridge
 */
class BrokerBridge(
  private val _brokerState: BrokerState,
  private val _kernel: KernelLike,
  private val _sparkContext: SparkContext
) extends BrokerName {
  /**
   * Represents the current state of the broker.
   */
  val state: BrokerState = _brokerState

  /**
   * Represents the context used as one of the main entrypoints into Spark.
   */
  val javaSparkContext: JavaSparkContext = new JavaSparkContext(_sparkContext)

  /**
   * Represents the context used as the SQL entrypoint into Spark for Python.
   */
  val sqlContext: SQLContext = new SQLContext(_sparkContext)

  /**
   * Represents the kernel API available.
   */
  val kernel: KernelLike = _kernel

  /**
   * Represents the configuration containing the current SparkContext setup.
   */
  val sparkConf: SparkConf = _sparkContext.getConf
}
