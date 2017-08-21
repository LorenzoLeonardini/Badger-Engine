emcc -std=c++11 -I"../Dependencies/FreeImage/include" "../Badger-core/src/audio/sound.cpp" "../Badger-core/src/audio/sound_manager.cpp" "../Badger-core/src/graphics/buffers/buffer.cpp" "../Badger-core/src/graphics/buffers/indexbuffer.cpp" "../Badger-core/src/graphics/buffers/vertexarray.cpp" "../Badger-core/src/graphics/layers/group.cpp" "../Badger-core/src/graphics/layers/layer.cpp" "../Badger-core/src/graphics/batchrenderer2d.cpp" "../Badger-core/src/graphics/font.cpp" "../Badger-core/src/graphics/font_manager.cpp" "../Badger-core/src/graphics/label.cpp" "../Badger-core/src/graphics/shader.cpp" "../Badger-core/src/graphics/sprite.cpp" "../Badger-core/src/graphics/texture.cpp" "../Badger-core/src/graphics/window.cpp" "../Badger-core/src/input/input.cpp" "../Badger-core/src/maths/mat4.cpp" "../Badger-core/src/maths/vec2.cpp" "../Badger-core/src/maths/vec3.cpp" "../Badger-core/src/maths/vec4.cpp" "../Badger-core/src/physics/entity.cpp" "../Badger-core/src/physics/hitbox.cpp" "../Badger-core/src/physics/physicsengine.cpp" "../Badger-core/examples/game.cpp" freetype.bc freeimage.bc -s USE_GLFW=3 -s FULL_ES3=1 -DBADGER_EMSCRIPTEN=1 -D_DEBUG_ENGINE=1 --memory-init-file 0 --embed-file res -O3 -o Web/badger.html