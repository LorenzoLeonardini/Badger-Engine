cmake_minimum_required(VERSION 3.0)

set(CMAKE_BUILD_TYPE Debug)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++14")

set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)

set(GLFW_BUILD_DOCS OFF CACHE BOOL "" FORCE)
set(GLFW_BUILD_TESTS OFF CACHE BOOL "" FORCE)
set(GLFW_BUILD_EXAMPLES OFF CACHE BOOL "" FORCE)

add_subdirectory(badger/vendor/GLFW)
add_subdirectory(badger/vendor/GLAD)
add_subdirectory(badger/vendor/imgui)

project(sample)

add_library(
    badger SHARED
    badger/src/Badger/Application.cpp
    badger/src/Badger/Layer.cpp
    badger/src/Badger/LayerStack.cpp
    badger/src/Badger/Log.cpp
    badger/src/Badger/ImGui/ImGuiLayer.cpp
    badger/src/Badger/Platform/Windows/WindowsWindow.cpp
    badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp
)

# add_library(
#     badgerlib STATIC
#     badger/src/Test.cpp
# )

add_executable(
    game
    game/src/SandboxApp.cpp
)

target_link_libraries(badger glfw)
target_link_libraries(badger glad)
target_link_libraries(badger imgui)
target_link_libraries(game badger)
target_link_libraries(game glfw)
# target_link_libraries(game glad)

set_target_properties(badger PROPERTIES COMPILE_FLAGS "-DBADGER_PLATFORM_LINUX -DBADGER_BUILD_DLL -DGLFW_INCLUDE_NONE")
include_directories(badger PRIVATE badger/src)
include_directories(badger PRIVATE badger/vendor/spdlog/include)

set_target_properties(game PROPERTIES COMPILE_FLAGS "-DBADGER_PLATFORM_LINUX")
include_directories(game PRIVATE badger/src)
include_directories(game PRIVATE badger/vendor/spdlog/include)
