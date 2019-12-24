#pragma once

#include "badgerpch.h"

#include "Badger/Core.h"
#include "Badger/Events/Event.h"

namespace Badger {

    struct WindowProps {
        std::string Title;
        unsigned int Width;
        unsigned int Height;

        WindowProps(const std::string &title = "Badger Engine",
                    unsigned int width = 640,
                    unsigned int height = 480)
                : Title(title), Width(width), Height(height) {}
    };

    class BADGER_API Window {
    public:
        using EventCallbackFn = std::function<void(Event&)>;

        virtual ~Window() {}

        virtual void OnUpdate() = 0;

        virtual unsigned int GetWidth() const = 0;
        virtual unsigned int GetHeight() const = 0;

        virtual void SetEventCallback(const EventCallbackFn &callback) = 0;
        virtual void SetVSync(bool enabled) = 0;
        virtual bool IsVSync() const = 0;

        static Window *Create(const WindowProps &props = WindowProps());
    };

}
