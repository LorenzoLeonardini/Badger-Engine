# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.13

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/pianka/BadgerEngine

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/pianka/BadgerEngine

# Include any dependencies generated for this target.
include CMakeFiles/badger.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/badger.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/badger.dir/flags.make

CMakeFiles/badger.dir/badger/src/Badger/Application.cpp.o: CMakeFiles/badger.dir/flags.make
CMakeFiles/badger.dir/badger/src/Badger/Application.cpp.o: badger/src/Badger/Application.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/pianka/BadgerEngine/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/badger.dir/badger/src/Badger/Application.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/badger.dir/badger/src/Badger/Application.cpp.o -c /home/pianka/BadgerEngine/badger/src/Badger/Application.cpp

CMakeFiles/badger.dir/badger/src/Badger/Application.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/badger.dir/badger/src/Badger/Application.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/pianka/BadgerEngine/badger/src/Badger/Application.cpp > CMakeFiles/badger.dir/badger/src/Badger/Application.cpp.i

CMakeFiles/badger.dir/badger/src/Badger/Application.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/badger.dir/badger/src/Badger/Application.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/pianka/BadgerEngine/badger/src/Badger/Application.cpp -o CMakeFiles/badger.dir/badger/src/Badger/Application.cpp.s

CMakeFiles/badger.dir/badger/src/Badger/Layer.cpp.o: CMakeFiles/badger.dir/flags.make
CMakeFiles/badger.dir/badger/src/Badger/Layer.cpp.o: badger/src/Badger/Layer.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/pianka/BadgerEngine/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/badger.dir/badger/src/Badger/Layer.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/badger.dir/badger/src/Badger/Layer.cpp.o -c /home/pianka/BadgerEngine/badger/src/Badger/Layer.cpp

CMakeFiles/badger.dir/badger/src/Badger/Layer.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/badger.dir/badger/src/Badger/Layer.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/pianka/BadgerEngine/badger/src/Badger/Layer.cpp > CMakeFiles/badger.dir/badger/src/Badger/Layer.cpp.i

CMakeFiles/badger.dir/badger/src/Badger/Layer.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/badger.dir/badger/src/Badger/Layer.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/pianka/BadgerEngine/badger/src/Badger/Layer.cpp -o CMakeFiles/badger.dir/badger/src/Badger/Layer.cpp.s

CMakeFiles/badger.dir/badger/src/Badger/LayerStack.cpp.o: CMakeFiles/badger.dir/flags.make
CMakeFiles/badger.dir/badger/src/Badger/LayerStack.cpp.o: badger/src/Badger/LayerStack.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/pianka/BadgerEngine/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/badger.dir/badger/src/Badger/LayerStack.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/badger.dir/badger/src/Badger/LayerStack.cpp.o -c /home/pianka/BadgerEngine/badger/src/Badger/LayerStack.cpp

CMakeFiles/badger.dir/badger/src/Badger/LayerStack.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/badger.dir/badger/src/Badger/LayerStack.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/pianka/BadgerEngine/badger/src/Badger/LayerStack.cpp > CMakeFiles/badger.dir/badger/src/Badger/LayerStack.cpp.i

CMakeFiles/badger.dir/badger/src/Badger/LayerStack.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/badger.dir/badger/src/Badger/LayerStack.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/pianka/BadgerEngine/badger/src/Badger/LayerStack.cpp -o CMakeFiles/badger.dir/badger/src/Badger/LayerStack.cpp.s

CMakeFiles/badger.dir/badger/src/Badger/Log.cpp.o: CMakeFiles/badger.dir/flags.make
CMakeFiles/badger.dir/badger/src/Badger/Log.cpp.o: badger/src/Badger/Log.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/pianka/BadgerEngine/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building CXX object CMakeFiles/badger.dir/badger/src/Badger/Log.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/badger.dir/badger/src/Badger/Log.cpp.o -c /home/pianka/BadgerEngine/badger/src/Badger/Log.cpp

CMakeFiles/badger.dir/badger/src/Badger/Log.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/badger.dir/badger/src/Badger/Log.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/pianka/BadgerEngine/badger/src/Badger/Log.cpp > CMakeFiles/badger.dir/badger/src/Badger/Log.cpp.i

CMakeFiles/badger.dir/badger/src/Badger/Log.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/badger.dir/badger/src/Badger/Log.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/pianka/BadgerEngine/badger/src/Badger/Log.cpp -o CMakeFiles/badger.dir/badger/src/Badger/Log.cpp.s

CMakeFiles/badger.dir/badger/src/Badger/ImGui/ImGuiLayer.cpp.o: CMakeFiles/badger.dir/flags.make
CMakeFiles/badger.dir/badger/src/Badger/ImGui/ImGuiLayer.cpp.o: badger/src/Badger/ImGui/ImGuiLayer.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/pianka/BadgerEngine/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building CXX object CMakeFiles/badger.dir/badger/src/Badger/ImGui/ImGuiLayer.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/badger.dir/badger/src/Badger/ImGui/ImGuiLayer.cpp.o -c /home/pianka/BadgerEngine/badger/src/Badger/ImGui/ImGuiLayer.cpp

CMakeFiles/badger.dir/badger/src/Badger/ImGui/ImGuiLayer.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/badger.dir/badger/src/Badger/ImGui/ImGuiLayer.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/pianka/BadgerEngine/badger/src/Badger/ImGui/ImGuiLayer.cpp > CMakeFiles/badger.dir/badger/src/Badger/ImGui/ImGuiLayer.cpp.i

CMakeFiles/badger.dir/badger/src/Badger/ImGui/ImGuiLayer.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/badger.dir/badger/src/Badger/ImGui/ImGuiLayer.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/pianka/BadgerEngine/badger/src/Badger/ImGui/ImGuiLayer.cpp -o CMakeFiles/badger.dir/badger/src/Badger/ImGui/ImGuiLayer.cpp.s

CMakeFiles/badger.dir/badger/src/Badger/Platform/Windows/WindowsWindow.cpp.o: CMakeFiles/badger.dir/flags.make
CMakeFiles/badger.dir/badger/src/Badger/Platform/Windows/WindowsWindow.cpp.o: badger/src/Badger/Platform/Windows/WindowsWindow.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/pianka/BadgerEngine/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Building CXX object CMakeFiles/badger.dir/badger/src/Badger/Platform/Windows/WindowsWindow.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/badger.dir/badger/src/Badger/Platform/Windows/WindowsWindow.cpp.o -c /home/pianka/BadgerEngine/badger/src/Badger/Platform/Windows/WindowsWindow.cpp

CMakeFiles/badger.dir/badger/src/Badger/Platform/Windows/WindowsWindow.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/badger.dir/badger/src/Badger/Platform/Windows/WindowsWindow.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/pianka/BadgerEngine/badger/src/Badger/Platform/Windows/WindowsWindow.cpp > CMakeFiles/badger.dir/badger/src/Badger/Platform/Windows/WindowsWindow.cpp.i

CMakeFiles/badger.dir/badger/src/Badger/Platform/Windows/WindowsWindow.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/badger.dir/badger/src/Badger/Platform/Windows/WindowsWindow.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/pianka/BadgerEngine/badger/src/Badger/Platform/Windows/WindowsWindow.cpp -o CMakeFiles/badger.dir/badger/src/Badger/Platform/Windows/WindowsWindow.cpp.s

CMakeFiles/badger.dir/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp.o: CMakeFiles/badger.dir/flags.make
CMakeFiles/badger.dir/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp.o: badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/pianka/BadgerEngine/CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Building CXX object CMakeFiles/badger.dir/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/badger.dir/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp.o -c /home/pianka/BadgerEngine/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp

CMakeFiles/badger.dir/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/badger.dir/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/pianka/BadgerEngine/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp > CMakeFiles/badger.dir/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp.i

CMakeFiles/badger.dir/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/badger.dir/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/pianka/BadgerEngine/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp -o CMakeFiles/badger.dir/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp.s

# Object files for target badger
badger_OBJECTS = \
"CMakeFiles/badger.dir/badger/src/Badger/Application.cpp.o" \
"CMakeFiles/badger.dir/badger/src/Badger/Layer.cpp.o" \
"CMakeFiles/badger.dir/badger/src/Badger/LayerStack.cpp.o" \
"CMakeFiles/badger.dir/badger/src/Badger/Log.cpp.o" \
"CMakeFiles/badger.dir/badger/src/Badger/ImGui/ImGuiLayer.cpp.o" \
"CMakeFiles/badger.dir/badger/src/Badger/Platform/Windows/WindowsWindow.cpp.o" \
"CMakeFiles/badger.dir/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp.o"

# External object files for target badger
badger_EXTERNAL_OBJECTS =

bin/libbadger.so: CMakeFiles/badger.dir/badger/src/Badger/Application.cpp.o
bin/libbadger.so: CMakeFiles/badger.dir/badger/src/Badger/Layer.cpp.o
bin/libbadger.so: CMakeFiles/badger.dir/badger/src/Badger/LayerStack.cpp.o
bin/libbadger.so: CMakeFiles/badger.dir/badger/src/Badger/Log.cpp.o
bin/libbadger.so: CMakeFiles/badger.dir/badger/src/Badger/ImGui/ImGuiLayer.cpp.o
bin/libbadger.so: CMakeFiles/badger.dir/badger/src/Badger/Platform/Windows/WindowsWindow.cpp.o
bin/libbadger.so: CMakeFiles/badger.dir/badger/src/Badger/Platform/OpenGL/ImGuiOpenGLRenderer.cpp.o
bin/libbadger.so: CMakeFiles/badger.dir/build.make
bin/libbadger.so: bin/libglfw3.a
bin/libbadger.so: bin/libglad.so
bin/libbadger.so: bin/libimgui.so
bin/libbadger.so: /usr/lib/librt.so
bin/libbadger.so: /usr/lib/libm.so
bin/libbadger.so: /usr/lib/libX11.so
bin/libbadger.so: CMakeFiles/badger.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/pianka/BadgerEngine/CMakeFiles --progress-num=$(CMAKE_PROGRESS_8) "Linking CXX shared library bin/libbadger.so"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/badger.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/badger.dir/build: bin/libbadger.so

.PHONY : CMakeFiles/badger.dir/build

CMakeFiles/badger.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/badger.dir/cmake_clean.cmake
.PHONY : CMakeFiles/badger.dir/clean

CMakeFiles/badger.dir/depend:
	cd /home/pianka/BadgerEngine && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/pianka/BadgerEngine /home/pianka/BadgerEngine /home/pianka/BadgerEngine /home/pianka/BadgerEngine /home/pianka/BadgerEngine/CMakeFiles/badger.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/badger.dir/depend

