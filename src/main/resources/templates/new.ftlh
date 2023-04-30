<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css"
                rel="stylesheet">
        <script src="/static/js/toSend.js"></script>
    </head>
    <body>

    <div id="navbar">
        <nav class="border-gray-200 bg-gray-50 dark:bg-gray-800 dark:border-gray-700">
            <div class="flex flex-wrap items-center justify-between p-4 mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
                <a href="/code/new" class="flex items-center">
                    <img src="/static/images/iconjpg.jpg" size="xl"/>
                    <span class="self-center text-2xl font-poppins text-base font-normal uppercase normal-nums font-semibold whitespace-nowrap dark:text-white">Share Code</span>
                </a>
                <button data-collapse-toggle="navbar-solid-bg" type="button" class="inline-flex items-center p-2 ml-3 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200" aria-controls="navbar-solid-bg" aria-expanded="false">
                    <span class="sr-only">Open main menu</span>
                    <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd"></path></svg>
                </button>
                <div class="hidden w-full md:block md:w-auto" id="navbar-solid-bg">
                    <ul class="flex flex-col font-medium mt-4 rounded-lg bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:border-0 md:bg-transparent ">
                        <li>
                            <a href="/code/new" class="block py-2 pl-3 pr-4 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0" aria-current="page">Create</a>
                        </li>
                        <li>
                            <a href="/code/find" class="block py-2 pl-3 pr-4 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0">Find By UUID</a>
                        </li>
                        <li>
                            <a href="/code/latest" class="block py-2 pl-3 pr-4 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0">Last Codes</a>
                        </li>
                        <li>
                            <a href="/code/contacts" class="block py-2 pl-3 pr-4 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0">Contact</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>

    <div id="form">
        <form onsubmit="send()" action="">
            <div class="h-full w-full mb-4 border border-gray-200 rounded-lg bg-gray-50 dark:bg-gray-700 dark:border-gray-600">
                <div class="px-4 py-2 bg-white rounded-b-lg dark:bg-gray-800">
                    <label for="code_snippet" class="block mb-2 text-2xl font-medium text-gray-900 dark:text-white">Enter your code: </label>
                    <textarea id="code_snippet" name="code" rows="30" class="block p-2 w-full text-base text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500" placeholder="Type your code here!" required></textarea>
                </div>
                <div></div>
                <div class="grid gap-6 mb-6 md:grid-cols-2 ml-4 mr-4">
                <div id="input_time">
                    <label for="time_restriction" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Time restriction(in seconds):</label>
                    <input id="time_restriction" type="text" value="0" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                </div>
                <div id="input_views">
                    <label for="views_restriction" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Views restriction:</label>
                    <input id="views_restriction" type="text" value="0" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                </div>
                </div>
                <div id="button" class="ml-4">
                <button type="submit" id="send_snippet" class="inline-flex text-white bg-gray-800 hover:bg-gray-900 focus:outline-none focus:ring-4 focus:ring-gray-300 font-medium rounded-lg text-base px-5 py-2.5 mr-2 mb-2 dark:bg-gray-800 dark:hover:bg-gray-700 dark:focus:ring-gray-700 dark:border-gray-700">Post</button>
                </div>
            </div>
        </form>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.6.5/flowbite.min.js"></script>
    </body>
</html>

