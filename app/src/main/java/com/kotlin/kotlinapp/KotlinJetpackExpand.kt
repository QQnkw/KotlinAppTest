package com.kotlin.kotlinapp

class KotlinJetpackExpand {
    /**
     * Collection KTX
     * Collection 扩展程序包含在 Android 的节省内存的集合库中使用的效用函数，
     * 包括 ArrayMap、LongParseArray、LruCache 等等。
     */
    fun aa() {
        /*val set = arraySetOf(1, 2, 3) + arraySetOf(4, 5, 6)
        val newSet = set + 7 + 8
        newSet.forEach { Log.d(TAG, "element is $it") }*/
    }

    /**
     * Fragment KTX
     * Fragment KTX 模块提供了一系列扩展程序以简化 Fragment API。
     */
    fun bb() {
        /*FragmentManager().commit {
            addToBackStack("...")
            setCustomAnimations(
                R.anim.enter_anim,
                R.anim.exit_anim)
            add(fragment, "...")
        }*/
    }

    /**
     * Lifecycle KTX
     * Lifecycle KTX 为每个 Lifecycle 对象定义一个 LifecycleScope。
     * 在此范围内启动的协程会在 Lifecycle 被销毁时取消。
     * 您可以使用 lifecycle.coroutineScope 或 lifecycleOwner.lifecycleScope 属性
     * 访问 Lifecycle 的 CoroutineScope。
     */
    fun cc() {
        //使用 lifecycleOwner.lifecycleScope 异步创建预计算文本：
        /*class MyFragment : Fragment() {
            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                viewLifecycleOwner.lifecycleScope.launch {
                    val params = TextViewCompat.getTextMetricsParams(textView)
                    val precomputedText = withContext(Dispatchers.Default) {
                        PrecomputedTextCompat.create(longTextContent, params)
                    }
                    TextViewCompat.setPrecomputedText(textView, precomputedText)
                }
            }
        }*/
    }

    /**
     * LiveData KTX
     * 使用 LiveData 时，您可能需要异步计算值;
     * 例如，您可能需要检索用户的偏好设置并将其传送给界面。
     * 在这些情况下，LiveData KTX 可提供一个 liveData 构建器函数，
     * 该函数会调用 suspend 函数，并将结果作为 LiveData 对象传送。
     */
    fun dd() {
        /*val user: LiveData<User> = liveData {
            val data = database.loadUser() // loadUser is a suspend function.
            emit(data)
        }*/
    }

    /**
     * Navigation KTX
     * Navigation 库的每个组件都有自己的 KTX 版本，
     * 用于调整 API 以使其更简洁且更符合 Kotlin 的语言习惯。
     */
    fun ee() {
        /* class MyDestination : Fragment() {

             // Type-safe arguments are accessed from the bundle.
             val args by navArgs<MyDestinationArgs>()

             override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                 view.findViewById<Button>(R.id.next)
                     .setOnClickListener {
                         // Fragment extension added to retrieve a NavController from
                         // any destination.
                         findNavController().navigate(R.id.action_to_next_destination)
                     }
             }

         }*/
    }

    /**
     * Palette KTX
     * Palette KTX 模块为使用调色板提供惯用的 Kotlin 支持。
     */
    fun ff() {
        /*val palette = Palette.from(bitmap).generate()
        val swatch = palette[target]*/
    }

    /**
     * Reactive Streams KTX
     * 利用 Reactive Streams KTX 模块可根据 ReactiveStreams 发布程序来创建可监测的 LiveData 流。
     */
    fun gg() {
        //借助 LiveDataReactiveStreams，
        // 您既可以利用 RxJava 及其丰富的运算符和工作安排功能，又可以享受 LiveData 的简便性
        /*val fun getUsersLiveData() : LiveData<List<User>> {
            val users: Flowable<List<User>> = dao.findUsers()
            return LiveDataReactiveStreams.fromPublisher(users)
        }*/
    }

    /**
     * Room KTX
     * Room 扩展程序增加了对数据库事务的协程支持。
     */
    fun hh() {
        /*使用 suspend 函数返回 User 对象列表
        @Query("SELECT * FROM Users")
         suspend fun getUsers(): List<User>*/

        /*利用 Kotlin 的 Flow 异步返回 User 列表。注意，
        使用 Flow 时，您还会收到有关您正在查询的表中任何更改的通知。*/
        /*@Query("SELECT * FROM Users")
        fun getUsers(): Flow<List<User>> */
    }

    /**
     * SQLite KTX
     * SQLite 扩展程序将与 SQL 相关的代码封装在事务中，从而避免编写大量样板代码。
     */
    fun ii() {
        /*db.transaction {
            // insert data
        }*/
    }

    /**
     * ViewModel KTX
     * ViewModel KTX 库提供了一个 viewModelScope() 函数，
     * 可让您更轻松地从 ViewModel 启动协程。
     * CoroutineScope 绑定至 Dispatchers.Main，
     * 并且会在清除 ViewModel 后自动取消。
     * 您可以使用 viewModelScope()，而无需为每个 ViewModel 创建一个新范围。
     */
    fun jj() {
        /*class MainViewModel : ViewModel() {
            // Make a network request without blocking the UI thread
            private fun makeNetworkRequest() {
                // launch a coroutine in viewModelScope
                viewModelScope.launch  {
                    remoteApi.slowFetch()
                }
            }

            // No need to override onCleared()
        }*/
    }

    /**
     * WorkManager KTX
     * 现在，您无需扩展 Worker，而可以扩展 CoroutineWorker，
     * 后者使用的 API 略有不同。
     *
     */
    fun kk(){
        //例如，如果要构建一个简单的 CoroutineWorker 以执行某些网络操作
        /*class CoroutineDownloadWorker(context: Context, params: WorkerParameters)
            : CoroutineWorker(context, params) {

            override suspend fun doWork(): Result = coroutineScope {
                val jobs = (0 until 100).map {
                    async {
                        downloadSynchronously("https://www.google.com")
                    }
                }

                // awaitAll will throw an exception if a download fails, which
                // CoroutineWorker will treat as a failure
                jobs.awaitAll()
                Result.success()
            }
        }*/

        //此外，WorkManager KTX 还向 Operations 和 ListenableFutures 添加扩展函数以暂停当前协程。
        //下面是暂停 enqueue() 返回的 Operation 的示例：
        /*WorkManager.getInstance()
            .beginWith(longWorkRequest)
            .enqueue().await()*/
    }
}